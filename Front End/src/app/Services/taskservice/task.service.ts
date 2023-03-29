import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { TaskModule } from 'src/app/models/task/task.module';
import { UserModule } from 'src/app/models/user/user.module';

@Injectable({
  providedIn: 'root'
})
export class TaskService {

  constructor(private http: HttpClient) { }

  public getAllTask(): Observable<any> {
    console.log("get All Task is running!!");
    return this.http.get<any>('http://localhost:8082/task/getAll');
  }

  public delete(taskId: number): Observable<TaskModule[]> {
    console.log("ID " + taskId);
    return this.http.delete<TaskModule[]>('http://localhost:8082/task/delete/' + `${taskId}`);
  }

  public addTask(task: TaskModule) {
    console.log(task);
    return this.http.post('http://localhost:8082/task/add', task);
  }

  public updateTask(task: TaskModule): Observable<TaskModule> {
    console.log('calling hospital service', task)
    return this.http.put<TaskModule>('http://localhost:8082/task/' + `${task.taskId}`, task);
  }
  public findTaskById(taskId: number): Observable<TaskModule> {
    return this.http.get<TaskModule>('http://localhost:8082/task/getOne/' + `${taskId}`);
  }

  public createTaskAndUser(task: TaskModule): Observable<TaskModule> {
    return this.http.post<TaskModule>('http://localhost:8082/task/tasks/' + `${task.taskId}`, task);
  }

}
