import { Component } from '@angular/core';
import { Router, ActivatedRoute } from "@angular/router";
import { AdvertisementService } from '../../services/Advertisement/AdvertisementService.service';
import { LoginService } from '../../services/SignUp/login.service';
import { Http, Response } from '@angular/http';



@Component({
    selector: 'UserProfileComponent',
    templateUrl: `./UserProfile.html`,
    providers:[AdvertisementService,LoginService]
})
export class UserProfileComponent {
    phone: any;
    email: any;
    username: any;
    lastName: any;
    firstName: any;
    userDetails1: any;
    userDetails: any;
    userName: any;
    token: any;

    constructor(private router: Router, private activatedRoute: ActivatedRoute, private adservices: AdvertisementService, private loginservices: LoginService) {
      /*  this.userName = this.loginservices.getUserName();
        this.loginservices.getUserProfile().subscribe((response: any) => {
            this.userDetails = response.data['user'];
            this.firstName = this.userDetails.firstName;
            this.lastName = this.userDetails.lastName;
            this.username = this.userDetails.userName;
            this.email = this.userDetails.email;
            this.phone = this.userDetails.phone;

            console.log("name:",this.firstName)
            this.loginservices.setUserData(this.userDetails);
            this.userDetails1 = this.loginservices.getUserData();

            console.log("user:",this.userDetails);
            console.log(response);

        })*/
    }
    ngOnInit() { this.token = this.activatedRoute.snapshot.params['auth-token']; 
console.log("hweqf ",this.token);
} 

}

