import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute, Router } from '@angular/router';
import { HolidayModule } from 'src/app/models/holiday/holiday.module';
import { HolidayService } from 'src/app/Services/holidayservice/holiday.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-update-holiday',
  templateUrl: './update-holiday.component.html',
  styleUrls: ['./update-holiday.component.css']
})
export class UpdateHolidayComponent implements OnInit {
  id: number = 0;

  holiday: HolidayModule = new HolidayModule();

  constructor(private holidayService: HolidayService, private snack: MatSnackBar, private router: Router, public route: ActivatedRoute) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params["id"];
    console.log("router param id is :: " + this.id);

    if (this.id > 0) {

      this.holidayService.findHolidayById(this.id)
        .subscribe(
          (data: any) => {
            console.log('data is renderd', data)
            this.holiday = data
            console.log(this.holiday, 'assigned data to doc')

          },
          (error) => {
            console.log(error)

          }
        );
    }

  }
  add() {
    if (this.holiday.holidayId === 0) {
      this.holidayService.addHoliday(this.holiday).subscribe
        (
          (data: any) => {
            console.log(data)
            this.snack.open("Successfully Submitted !! ", '',
              {
                duration: 3000,
                verticalPosition: 'top',
              });
          },
          (error) => {
            console.log(error)
            this.snack.open("SomeThing Went Wrong !! ", '',
              {
                duration: 3000,
                verticalPosition: 'top',
              });
          }
        )
    }
    else {

      this.holidayService.updateHoliday(this.holiday).subscribe
        (
          (data: any) => {
            console.log(data)
            this.snack.open("Holiday Update Successfully!!! ", '',
              {
                duration: 3000,
                verticalPosition: 'top',
              });
            this.router.navigateByUrl("/holidays")
          },
          (error) => {
            console.log(error)
            this.snack.open("SomeThing Went Wrong !! ", '',
              {
                duration: 3000,
                verticalPosition: 'top',
              });
          }
        )
    }

  }

}
