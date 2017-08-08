import { Component } from '@angular/core';
import { LoginService } from '../../services/SignUp/login.service';
import { AdvertisementService } from "../../services/Advertisement/AdvertisementService.service";

@Component({
  selector: 'nav-bar',
  templateUrl: `./NavigationBar.html`,
    providers: [AdvertisementService,LoginService]

})
export class NavigationBarComponent  { 
  token: any;
  constructor(private advertisementService: AdvertisementService,private loginService:LoginService){}

 }
