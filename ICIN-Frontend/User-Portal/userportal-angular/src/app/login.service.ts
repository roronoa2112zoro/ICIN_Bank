import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  readonly rootUrl = 'http://ec2-3-94-64-169.compute-1.amazonaws.com:8080';

  constructor(private http: HttpClient) { }

  loginUser(userName: string, password: string) {
    var body = {
      username: userName,
      password: password
    }
    return this.http.post(this.rootUrl + '/login', body);
  }
}
