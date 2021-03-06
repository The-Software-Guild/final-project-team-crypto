import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { map } from 'rxjs';
import { SharedService } from 'src/app/shared.service';
import { AuthenticationService } from '../../auth/authentication.service';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent implements OnInit {

  loginForm: FormGroup;

  constructor(
    private authService: AuthenticationService,
    private formBuilder: FormBuilder,
    private router: Router,
    private ss: SharedService
    ) {
      this.ss = ss;
     }

    ngOnInit(): void {
      this.loginForm = new FormGroup({
        username: new FormControl(null, [Validators.required]),
        password: new FormControl(null, [Validators.required, Validators.minLength(3)])
      })
    }

    onSubmit() {
      if(this.loginForm.invalid) {
        return;
      }
      console.log(this.loginForm.value);
      this.ss.login();
      this.authService.login(this.loginForm.value).pipe(
        map(token => this.router.navigate(['account']))
      ).subscribe()
      
    }

}
