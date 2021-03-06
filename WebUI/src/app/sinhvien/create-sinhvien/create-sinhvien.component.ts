import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SinhVien } from 'src/app/model/sinhvien.model';
import { SinhVienService } from 'src/app/service/sinhvien.service';

@Component({
  selector: 'app-create-sinhvien',
  templateUrl: './create-sinhvien.component.html',
  styleUrls: ['./create-sinhvien.component.css']
})
export class CreateSinhvienComponent implements OnInit {

  sinhvien: SinhVien= new SinhVien();
  constructor(private sinhvienService: SinhVienService, private router: Router) {

  }

  ngOnInit(): void {
    this.sinhvien= new SinhVien();
  }

  onSubmit(){
    this.sinhvienService.createSinhVien(this.sinhvien).subscribe(data=> console.log(data), error=> console.log(error));
    this.router.navigate(['/listsinhviens'])
  }
}
