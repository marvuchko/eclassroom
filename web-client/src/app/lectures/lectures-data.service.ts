import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Lecture } from '../models/lecture';
import { VideoThread } from '../models/video-thread';

@Injectable({
  providedIn: 'root'
})
export class LecturesDataService {
  private baseUrl = 'http://localhost:8080/eclassroom/api/lecture';
  constructor(private http: HttpClient) { }

  getLectures(): Observable<Lecture[]> {
    return this.http.get<Lecture[]>(this.baseUrl);
  }

  getLecture(id: string): Observable<Lecture> {
    const url = `${this.baseUrl}/${id}`;
    return this.http.get<Lecture>(url);
  }

  getVideoThreads(videoId: string): Observable<VideoThread[]> {
    throw new Error('Not implemented yet');
  }

  deleteLecture(lectureId: string): Observable<boolean> {
    throw new Error('Not implemented yet');
  }

  addLecture() { }
}
