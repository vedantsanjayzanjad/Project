import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { TaskModule } from 'src/app/models/task/task.module';
import { TaskService } from 'src/app/Services/taskservice/task.service';

@Component({
  selector: 'app-taskuser',
  templateUrl: './taskuser.component.html',
  styleUrls: ['./taskuser.component.css']
})
export class TaskuserComponent implements OnInit {

  constructor(private http: HttpClient, private taskService: TaskService) {

  }

  task: TaskModule[] = [];

  ngOnInit(): void {
    this.taskService.getAllTask()
      .subscribe(
        {
          next: (data) => {
            console.log();
            this.task = data
            console.log(JSON.stringify(this.task));
          }
        });
  }
}
