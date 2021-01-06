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

  getSinhVienBymaSV(ID: String): Observable<any> {
    return this.http.get(this.baseUrl+"/find/" + ID);
  }

  createSinhVien(sinhvien: SinhVien): Observable<object> {
    return this.http.post<object>(this.baseUrl+"/add", sinhvien.id );
  }

  updateSinhVien(ID: String, sinhvien: SinhVien): Observable<object> {
    return this.http.put<object>(this.baseUrl + "/update", sinhvien);
  }

  deleteSinhVien(ID: String): Observable<any> {
    return this.http.delete<any>(this.baseUrl+"/delete/" + ID);
  }
}
