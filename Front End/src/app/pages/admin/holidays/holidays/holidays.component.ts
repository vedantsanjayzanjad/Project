import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource, MatTableDataSourcePaginator } from '@angular/material/table';
import { HolidayModule } from 'src/app/models/holiday/holiday.module';
import { HolidayService } from 'src/app/Services/holidayservice/holiday.service';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';


@Component({
  selector: 'app-holidays',
  templateUrl: './holidays.component.html',
  styleUrls: ['./holidays.component.css']
})
export class HolidaysComponent implements OnInit {

  constructor(private holidayService: HolidayService, private router: Router) { }
  holiday: HolidayModule[] = [];

  ngOnInit(): void {
    this.holidayService.getAllHoliday()
      .subscribe(
        {
          next: (data) => {
            console.log();
            this.holiday = data
            console.log(JSON.stringify(this.holiday));
          }
        });
  }

  delete(holidayId: number) {
    console.log(holidayId);
    this.holidayService.delete(holidayId)
      .subscribe({
        next: (data) => {
          this.holiday = data
          console.log(this.holiday);
          location.reload();
        }
      });

  }

}
