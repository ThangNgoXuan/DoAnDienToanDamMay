import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { ApiResponse } from 'src/app/model/api.response';
import { SinhVien } from 'src/app/model/sinhvien.model';
import { SinhVienService } from 'src/app/service/sinhvien.service';

@Component({
  selector: 'app-list-sinhvien',
  templateUrl: './list-sinhvien.component.html',
  styleUrls: ['./list-sinhvien.component.css']
})
export class ListSinhvienComponent implements OnInit {

  listsinhviens !: Observable< SinhVien[]>;
  constructor(private sinhvienService:SinhVienService, private router:Router) { }

  ngOnInit(): void {
    this.listsinhviens= this.sinhvienService.getSinhVien();
  }



  reloadData() {
    this.listsinhviens = this.sinhvienService.getSinhVien();
  }


  deleteSinhVien(id: String) {
    this.sinhvienService.deleteSinhVien(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
      error => console.log(error));
  }
   updateSinhVien(id:String)
   {
    this.router.navigate(['/updatesinhvien',id])
   }

}
