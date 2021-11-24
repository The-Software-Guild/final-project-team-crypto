import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { map, tap, switchMap } from "rxjs/operators";

import { JwtHelperService } from "@auth0/angular-jwt";
import { Observable, of } from 'rxjs';

import { User } from './user.interface';

export interface LoginForm {
  username: string;
  password: string;
};

export const JWT_NAME = 'user-token';


@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor(private http: HttpClient, private jwtHelper: JwtHelperService) { }

  login(loginForm: LoginForm) {  

    return this.http.post<any>('http://localhost:8080/api/cryptoinventory/login', {username: loginForm.username, password: loginForm.password}).pipe(
      map((token) => {
        console.log('token');
        localStorage.setItem(JWT_NAME, token.username);
        return token;
      })
    )
  }

  logout() {
    localStorage.removeItem(JWT_NAME);
  }

  register(user: User) {
    return this.http.post<any>('http://localhost:8080/api/cryptoinventory/begin', user).pipe(
      tap(user => console.log(user)),
      map(user => user)
    )
  }

  // isAuthenticated(): boolean {
  //   const token = localStorage.getItem(JWT_NAME);
  //   return !this.jwtHelper.isTokenExpired(token || '');
  // }

  // getUserId(): Observable<number>{
  //   return of(localStorage.getItem(JWT_NAME)).pipe(
  //     switchMap((jwt: string) => of(this.jwtHelper.decodeToken(jwt)).pipe(
  //       map((jwt) => jwt.user.id))
  //     )
  //   )
  // }

}
