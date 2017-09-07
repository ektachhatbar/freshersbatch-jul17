import { Component } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { AdvertisementService } from '../../services/Advertisement/AdvertisementService.service';
import { LoginService } from '../../services/SignUp/login.service';

@Component({
  selector: 'my-app',
  templateUrl: `./MyAccount.html`,
  providers: [AdvertisementService,LoginService]

})
export class MyAccountComponent  { 
  myadvertisements: Array<any>=[];
  id: any;
  successfullReg: any;
  storeReg: any;
  logoutToken: any;
  categories: Array<any> = [];
  name: any; 
  authToken:any;
  allAdver: any;
  actions:any;
  userinfo:any;
  updateId:any;
  updateData:any={id:null,title:null,category:null,description:null,name:null};
    constructor(private router: Router,advertisementService: AdvertisementService,private activatedRoute: ActivatedRoute,private loginService:LoginService) {
  advertisementService.getAllCategories().subscribe((response:any)=> { 
    response.data.itemList.forEach((item:any)=>{
      this.categories.push(item.name);
      console.log("Categories ",item.name);
      this.displayMyAd();
      this.getActions();
      this.user();
    })
  }); 


}
ngOnInit() { 
  this.name = this.activatedRoute.snapshot.params['userName']; 
  this.authToken = this.activatedRoute.snapshot.params['authToken']; 
  console.log("auth-token ",this.authToken);
  
} 
displayMyAd() {
        this.loginService.displayMyAllAdv(this.authToken).subscribe((data) => {
            //console.log('Response! 1: ', data)
            this.allAdver = data.data.mypostList;
            console.log('Response! 2: ', this.allAdver);
        });
    }
    getActions(){
      this.loginService.getActions(this.authToken).subscribe((data) => {
            //console.log('Response! 1: ', data)
            this.actions = data.data.actionList;
            console.log('Actions: ', this.actions);
        });
    }
logout(){
  this.logoutToken=this.authToken;
  this.authToken=null;
  this.loginService.logoutUser(this.logoutToken).subscribe((response)=>{},(error)=>{});
  this.loginService.setToken(null);
  this.router.navigate(['']);
}

postAd(title1:any , name1:any , category1:any , description1:any):void{
  console.log("post ",this.authToken);
    this.storeReg ={title:title1 ,name:name1 ,category:category1,description:description1};
    this.myadvertisements.push({title:title1 ,name:name1 ,category:category1,description:description1});
    this.loginService.postAdvertisement(this.storeReg,this.authToken).subscribe((data:any)=> { 
      this.successfullReg=data;
      this.id =  this.successfullReg.data['id'];
      console.log('Received products: ', this.successfullReg);                   
      console.log("my ad ",this.myadvertisements);
      if(this.authToken==null){

      }else{
        alert("Post Successfully");
      }
    });
  }
  user(){
            console.log("user auth token",this.authToken);
            this.loginService.getUserProfile(this.authToken).subscribe((data) => {
            //console.log('Response! 1: ', data)
            this.userinfo = data;
            console.log('User Info: ', this.userinfo);
        });
  }

  deleteAd(obj: any) {
        console.log("Index of del", obj);
        this.loginService.deleteAd(obj,this.authToken).subscribe((data) => {
            console.log("Delete ", data);
            alert("Deleted Successfully");
            this.displayMyAd();
        });
        
        //console.log("After delete ",this.displayAd());
    }
    updateAd(uid:any,tit:String,uname:String,cat:String,des:String){
      this.updateData={id:uid,title:tit,name:uname,category:cat,description:des};
      this.loginService.updateAd(this.updateData,this.authToken).subscribe((data) => {
            console.log('Response edited data: ', data)
            alert("Updated Successfully");
            this.displayMyAd();
        });
    }
}
