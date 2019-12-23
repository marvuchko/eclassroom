import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from './../../environments/environment';
import { Lecture } from '../models/lecture';
import { IAddLectureOptions } from '../models/add-lecture-options';
import { map } from 'rxjs/operators';
import { DomSanitizer, SafeResourceUrl } from '@angular/platform-browser';

@Injectable({
  providedIn: 'root'
})
export class LecturesDataService {
  private lectureBaseUrl = `${environment.server}/eclassroom/api/lecture`;

  constructor(private http: HttpClient, private domSanitizer: DomSanitizer) { }

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

  getVideoData(videoUrl: string): Observable<SafeResourceUrl> {
    return this.http.get(videoUrl, {responseType: 'blob'}).pipe(map(response => {
      const url = URL.createObjectURL(response);
      const sanitized = this.domSanitizer.bypassSecurityTrustResourceUrl(url);
      return sanitized;
    }))
  }
}
