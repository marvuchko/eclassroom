import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from './../../environments/environment';
import { VideoThread } from '../models/video-thread';
import { VideoThreadMessage } from '../models/video-thread-message';
import { IStartThreadOptions } from '../models/start-thread-options';

@Injectable({
  providedIn: 'root'
})
export class VideoThreadsDataService {

  private baseUrl = `${environment.server}/eclassroom/api`;

  constructor(private http: HttpClient) { }

  getThreadMessages(threadId: string): Observable<VideoThreadMessage[]> {
    const url = `${this.baseUrl}/thread/${threadId}/message`;
    return this.http.get<VideoThreadMessage[]>(url);
  }

  startThread(options: IStartThreadOptions): Observable<VideoThread> {
    const url = `${this.baseUrl}/video/${options.videoId}/thread`;
    return this.http.post<VideoThread>(url, options);
  }

  postMessage(threadId: string, authorFullName: string, authorEmail: string, content: string): Observable<VideoThreadMessage> {
    const url = `${this.baseUrl}/thread/${threadId}/message`;
    const data = {
      content,
      authorFullName,
      authorEmail
    };
    return this.http.post<VideoThreadMessage>(url, data);
  }
}
