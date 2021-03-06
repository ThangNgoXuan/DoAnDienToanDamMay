import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ApiResponse } from 'src/app/model/api.response';
import { SinhVien } from 'src/app/model/sinhvien.model';
import { SinhVienService } from 'src/app/service/sinhvien.service';

@Component({
  selector: 'app-update-sinhvien',
  templateUrl: './update-sinhvien.component.html',
  styleUrls: ['./update-sinhvien.component.css']
})
export class UpdateSinhvienComponent implements OnInit {

  id !: String;
  sinhvien !: SinhVien;

  constructor(private route: ActivatedRoute,private router: Router,
    private sinhvienService: SinhVienService) { }

  ngOnInit(): void {
    this.sinhvien= new SinhVien();
    this.id= this.route.snapshot.params['id'];
    this.sinhvienService.getSinhVienBymaSV(this.id).subscribe(data => {
      console.log(data)
      this.sinhvien = data;
    }, error => console.log(error));
  }

  onSubmit() {
    this.sinhvienService.updateSinhVien(this.id, this.sinhvien)
      .subscribe(data => console.log(data), error => console.log(error));
    this.sinhvien = new SinhVien();
    this.router.navigate(['/listsinhviens']);
    }
    list(){
      this.router.navigate(['/listsinhviens']);
    }
}
