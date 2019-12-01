import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from './../../environments/environment';
import { Lecture } from '../models/lecture';
import { IAddLectureOptions } from '../models/add-lecture-options';

@Injectable({
  providedIn: 'root'
})
export class LecturesDataService {
  private lectureBaseUrl = `${environment.server}/eclassroom/api/lecture`;

  constructor(private http: HttpClient) { }

  getLectures(): Observable<Lecture[]> {
    return this.http.get<Lecture[]>(this.lectureBaseUrl);
  }

  getLecture(id: string): Observable<Lecture> {
    const url = `${this.lectureBaseUrl}/${id}`;
    return this.http.get<Lecture>(url);
  }

  deleteLecture(lectureId: string): Observable<boolean> {
    const url = `${this.lectureBaseUrl}/${lectureId}`;
    return this.http.delete<boolean>(url);
  }

  addLecture(options: IAddLectureOptions): Observable<Lecture> {
    const headers = new HttpHeaders();
    headers.append('Content-Type', 'multipart/form-data');
    const formData = new FormData();
    Object.keys(options).forEach(key => {
      formData.append(key, options[key]);
    });
    return this.http.post<Lecture>(this.lectureBaseUrl, formData, { headers });
  }
}
