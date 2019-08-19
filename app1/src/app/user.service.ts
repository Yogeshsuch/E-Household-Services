import { Injectable } from '@angular/core';
import { Http, RequestOptions, Headers } from '@angular/http';
import { ActivatedRouteSnapshot, RouterStateSnapshot, CanActivate } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class UserService implements CanActivate {

  constructor(private http : Http) { }

  canActivate(route:ActivatedRouteSnapshot, state: RouterStateSnapshot){
    if(sessionStorage['login_status'] == '1'){
      return true;
    }
    alert("Please login");
    return false;
  }

  get(zip : any)
  {
    return this.http.get('http://localhost:8080/spring_mvc_hibernate_template/zipCode/zip/' + zip);
  }

  post(name,password,email,mobileNo,address,zip,locality,city,state){

    const body = {
      address:address,
      email:email,
      mobileNo:mobileNo,
      name:name,
      password:password,     
      zip:zip,
      city:city,
      locality:locality,
      state:state
    }
    console.log(body);
    const headers = new Headers({'Content-Type' : 'application/json'});
    const requestOptions = new RequestOptions({headers:headers})

    return this.http.post('http://localhost:8080/spring_mvc_hibernate_template/customer/register', body, requestOptions);
  }

  userLogin(email,password){
    const body = {
      email : email,
      password : password
    }
    console.log(body);
    const headers = new Headers({'Content-Type' : 'application/json'});
    const requestOptions = new RequestOptions({headers:headers})

    return this.http.post('http://localhost:8080/spring_mvc_hibernate_template/customer/login', body, requestOptions);

  }

  getUserDetails(id){
      return this.http.get('http://localhost:8080/spring_mvc_hibernate_template/customer/getDetails/'+ id );
  }

  getOrderDetails(id){
    return this.http.get('http://localhost:8080/spring_mvc_hibernate_template/order/ordersDetails/' + id);
  }

  submitFeedback(oid,name,email,message){
    const body = {
      oid:oid,
      name:name,
      email:email,
      message:message
    }
    console.log(body);
    const headers = new Headers({'Content-Type' : 'application/json'});
    const requestOptions = new RequestOptions({headers:headers})

    return this.http.post('http://localhost:8080/spring_mvc_hibernate_template/customer/feedback', body, requestOptions);
  }

  updateUser(address,cid, city, email, locality, mobileNo, name,password, state, zip){
    const body = {
      address:address,
      cid:cid,
      city:city,
      email:email,
      locality:locality,
      mobileNo:mobileNo,
      name:name,
      password:password,
      state:state,
      zip:zip
    }
    console.log(body);
    const headers = new Headers({'Content-Type' : 'application/json'});
    const requestOptions = new RequestOptions({headers:headers})

    return this.http.put('http://localhost:8080/spring_mvc_hibernate_template/customer/update', body, requestOptions);
  }


}
