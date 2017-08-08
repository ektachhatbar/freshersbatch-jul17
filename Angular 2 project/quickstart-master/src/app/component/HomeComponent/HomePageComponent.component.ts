import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AdvertisementService } from '../../services/Advertisement/AdvertisementService.service';
import { LoginService } from '../../services/SignUp/login.service';

@Component({
  selector: 'home-page',
  templateUrl: `./HomePage.html`,
  providers: [AdvertisementService,LoginService]

})
export class HomePageComponent  { 
  advertisements:Array<any>=[];
  public flag: number = 0;
  successfullReg: any;
  storeReg: any;
  authToken: any;
  successfullLog: any;
  storeLog: any;

  categories: Array<any> = [];


  productsarray: any[];
      mySearchAdvertisement: any[] = [];
      allproducts: any[] = [];
      reg: any;


  constructor(private router: Router,private advertisementService: AdvertisementService,private loginService:LoginService) {
    advertisementService.getAllCategories().subscribe((response:any)=> { 
      response.data.itemList.forEach((item:any)=>{
        this.categories.push(item.name);
        console.log("Categories ",item.name);
      })
    }); 
    advertisementService.getAllAdvertisements().subscribe((response:any)=>{
      console.log(response);
      response.data.advertiseList.forEach((ad:any)=>{
        this.advertisements.push({"title":ad.title,"username":ad.name,"data":ad.createdDate,"category":ad.category,"description":ad.description});
      });
    });
  }

  checkRegister(fName:string , lName:string , uName:string , pwd:string ,emailID:string, phn:string):void{
    this.storeReg ={firstName:fName ,lastName:lName ,userName:uName ,password:pwd ,email:emailID ,phone:phn};
    this.loginService.register(this.storeReg).subscribe((data:any)=> { 
      this.successfullReg=data;
      console.log('Received products: ', this.successfullReg); 
      if(this.storeReg.firstName===null){
        alert("OOPs..!! Not Registered");
      }else{
        alert("Successfully Registered...!!!");
        this.router.navigate(['']);
      }
    });
  }


  checkLogin(uName:string , pwd:string ):void{
    this.storeLog = {userName:uName ,password:pwd };
    this.loginService.login(this.storeLog).subscribe((data:any)=> { 
      this.successfullLog=data;
      console.log('Login: ', this.successfullLog);
      this.authToken =  this.successfullLog.data['auth-token'];
      if(this.authToken == null){
        this.successfullLog = false;
        alert("Invalid Username or Password");
      }else{
        this.loginService.setToken(this.authToken);
        this.successfullLog = true;
        this.router.navigate(['/loginHome',this.authToken,this.storeLog.userName]);
      }   
    });
    this.searchProducts();  
  }
  searchProducts(){
    this.reg=this.advertisementService.allproducts();
    this.reg.subscribe((data:any)=>{
          console.log(data);
          this.allproducts=data.data.advertiseList;
          console.log('All Ad details :',this.allproducts)
    })
  }
  Productsbycategory(search:string){
      this.reg=this.advertisementService.productscategory();
      this.reg.subscribe((data:any)=>{
          console.log('Data:',data);
          this.allproducts=data.data.advertiseList;
          this.productsarray = this.allproducts;
          console.log('All Ad details :',this.allproducts)
          console.log('productsArray :',this.productsarray)
          this.mySearchAdvertisement=[];
          for(let product of this.productsarray){

            console.log(product.category);
            if(product.category == search){
                console.log('searched product:',product);
                this.mySearchAdvertisement.push(product)
                console.log(this.mySearchAdvertisement);
            }
          }
      })
  }


}
