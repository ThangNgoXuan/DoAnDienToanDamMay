import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ApiResponse } from '../model/api.response';
import {Observable} from "rxjs/index";
import { SinhVien } from '../model/sinhvien.model';
@Injectable({
  providedIn: 'root'
})
export class SinhVienService {

  constructor(private http: HttpClient) { }
  private baseUrl  = "http://localhost:8086";



  getSinhVien() : Observable<SinhVien[]> {
    return this.http.get<SinhVien[]>(this.baseUrl+"/list");
  }

  getSinhVienBymaSV(ID: String): Observable<SinhVien> {
    return this.http.get<SinhVien>(this.baseUrl+"/find/" + ID);
  }

  createSinhVien(sinhvien: SinhVien): Observable<object> {
    return this.http.post<object>(this.baseUrl+"/add", sinhvien);
  }

  updateSinhVien(ID: String, sinhvien: SinhVien): Observable<object> {
    return this.http.put<object>(this.baseUrl + "/update/"+ID, sinhvien);
  }

  deleteSinhVien(ID: String): Observable<object> {
    return this.http.delete<object>(this.baseUrl+"/Delete/" + ID);
  }
}
