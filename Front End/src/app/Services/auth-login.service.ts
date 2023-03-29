import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { UserModule } from '../models/user/user.module';

@Injectable({
  providedIn: 'root'
})
export class AuthLoginService {

  constructor(private http: HttpClient) { }

  public loginByUserRoles(user: UserModule) {
    console.log(user);
    return this.http.post('http://localhost:8082/user/login', user)

  }
}
