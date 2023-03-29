import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HolidayModule } from 'src/app/models/holiday/holiday.module';

@Injectable({
  providedIn: 'root'
})
export class HolidayService {

  constructor(private http: HttpClient) { }

  public getAllHoliday(): Observable<any> {
    console.log("get All Hospital is running!!");
    return this.http.get<any>('http://localhost:8082/holiday/getAll');
  }

  public delete(holidayId: number): Observable<HolidayModule[]> {
    console.log("ID " + holidayId);
    return this.http.delete<HolidayModule[]>('http://localhost:8082/holiday/delete/' + `${holidayId}`);
  }

  public addHoliday(holiday: HolidayModule) {
    console.log(holiday.holidayDate);
    return this.http.post('http://localhost:8082/holiday/add', holiday);
  }

  public updateHoliday(holiday: HolidayModule): Observable<HolidayModule> {
    console.log('calling hospital service', holiday)
    return this.http.patch<HolidayModule>('http://localhost:8082/holiday/' + `${holiday.holidayId}`, holiday);
  }
  public findHolidayById(holidayId: number): Observable<HolidayModule> {
    return this.http.get<HolidayModule>('http://localhost:8082/holiday/getOne/' + `${holidayId}`);
  }


}
