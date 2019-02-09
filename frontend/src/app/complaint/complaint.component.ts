import { AdminService } from './../service/admin.service';
import { PromotionService } from './../service/promotion.service';
import { ComplaintService } from './../service/complaint.service';
import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-complaint',
  templateUrl: './complaint.component.html',
  styleUrls: ['./complaint.component.css']
})
export class ComplaintComponent implements OnInit {

  companys: Array<any>
  maids: Array<any>
  complaintTypes : Array<any>

  views: any = {
    companySelect: '',
    maidSelect: '',
    complaintTypeSelect: '',
    complaintDetail: '',
    complaintDateSelect: ''
  };


  constructor(private complaintService: ComplaintService, private httpClient: HttpClient , private promotionService : PromotionService ,private adminService: AdminService) { }

  ngOnInit() {

    this.promotionService.getCompanyName().subscribe(data => {
      this.companys = data;
      console.log(this.companys);
    });
    this.complaintService.getComplaintType().subscribe(data => {
      this.complaintTypes = data;
      console.log(this.complaintTypes);
    });

  }
  dataChanged() {
    this.adminService.getMaidInCompany(this.views.companySelect).subscribe(data => {
      this.maids = data;
      console.log(this.maids);
    });
  }
    
  save_func(){
    if(this.views.companySelect === '') {
      alert('กรุณาเลือกบริษัท');
    }else if(this.views.maidSelect === ''){
      alert('กรุณาเลือกแม่บ้าน')
    }
    this.httpClient.post('http://localhost:8080/complaint/' + this.views.companySelect + '/' + this.views.maidSelect  + '/' + this.views.complaintTypeSelect + '/' + this.views.complaintDetail + '/' + this.views.complaintDateSelect, this.views)
         .subscribe(
             data => {
                 console.log('PUT Request is successful', data);
                 alert('ร้องเรียนสำเร็จ');
                 location.reload();
             },
             error => {
                  console.log('Rrror', error);
                  alert('เกิดข้อผิดพลาด');
            }
    );
  }

  reset_func() {
  }

}
