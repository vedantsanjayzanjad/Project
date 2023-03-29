import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { TaskModule } from 'src/app/models/task/task.module';
import { UserModule } from 'src/app/models/user/user.module';

@Injectable({
  providedIn: 'root',
})
export class UserServiceService {
  constructor(private http: HttpClient) { }

  public registerUser(user: UserModule) {
    console.log(user);
    return this.http.post('http://localhost:8082/user/add', user);
  }


  public getAllUser(): Observable<any> {
    console.log("get All user is running!!");
    return this.http.get<any>('http://localhost:8082/user/getAll');
  }

  public getTaskByUser(id: number): Observable<TaskModule[]> {
    console.log("get All user is running!!");
    return this.http.get<TaskModule[]>('http://localhost:8082/task/' + `${id}`);
  }
}
