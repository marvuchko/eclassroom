import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Lecture } from '../models/lecture';
import { VideoThread } from '../models/video-thread';
import { IAddLectureOptions } from '../models/add-lecture-options';

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
    const url = `${this.baseUrl}/${lectureId}`;
    return this.http.delete<boolean>(url);
  }

  addLecture(options: IAddLectureOptions): Observable<Lecture> {
    const headers = new HttpHeaders();
    headers.append('Content-Type', 'multipart/form-data');
    const formData = new FormData();
    Object.keys(options).forEach(key => {
      formData.append(key, options[key]);
    });
    return this.http.post<Lecture>(this.baseUrl, formData, { headers });
  }
}
