import { Injectable } from '@angular/core';
import { Headers, Http, RequestOptions } from '@angular/http';

@Injectable({
  providedIn: 'root'
})
export class FreelancerService {

  
  constructor(private http : Http) { }

  get(zip:any)
  {
    return this.http.get('http://localhost:8080/spring_mvc_hibernate_template/zipCode/zip/' + zip);
  }

  post(file: any, name,password,email,mobileNo,address,zip,locality,city,state,skill) {
    
    const formData = new FormData();
    formData.append('name', name);
    formData.append('password', password);
    formData.append('email', email);
    formData.append('mobileNo', mobileNo);
    formData.append('address', address);
    formData.append('zip', zip);
    formData.append('locality', locality);
    formData.append('city', city);
    formData.append('state', state);
    formData.append('skill', skill);
    formData.append('file', file);
    
    return this.http.post('http://localhost:8080/spring_mvc_hibernate_template/professional/register/', formData);
  }

  getSkill(){
    return this.http.get('http://localhost:8080/spring_mvc_hibernate_template/professional/skill');
  }

  freelancerLogin(email,password){
    const body = {
      email : email,
      password : password
    }
    console.log(body);
    const headers = new Headers({'Content-Type' : 'application/json'});
    const requestOptions = new RequestOptions({headers:headers})

    return this.http.post('http://localhost:8080/spring_mvc_hibernate_template/professional/login', body, requestOptions);

  }

  getCustomers() {
    return this.http.get('http://localhost:8080/spring_mvc_hibernate_template/customer/list');
  }

  freelancerDetails(id){
    return this.http.get('http://localhost:8080/spring_mvc_hibernate_template/professional/getDetails/'+ id );
  }

}