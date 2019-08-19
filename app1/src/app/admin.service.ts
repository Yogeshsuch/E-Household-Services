import { Injectable } from '@angular/core';
import { Headers,RequestOptions, Http } from '@angular/http';

@Injectable({
  providedIn: 'root'
})
export class AdminService {
  constructor(private http : Http) { }

  login(email: any, password: any) {
    const body = {
      email : email,
      password : password
    }
    const headers = new Headers({'Content-Type': 'application/json'});
    const requestOptions = new RequestOptions({headers: headers});
    return this.http.post('http://localhost:8080/spring_mvc_hibernate_template/admin/login', body, requestOptions);  
  }

  getCustomers() {
    return this.http.get('http://localhost:8080/spring_mvc_hibernate_template/customer/list');
  }

  getProfessionals() {
    return this.http.get('http://localhost:8080/spring_mvc_hibernate_template/professional/list');
  }

  onVerify(id: any) {
    console.log(id);
    return this.http.get('http://localhost:8080/spring_mvc_hibernate_template/professional/verify/' + id);
  }

  deleteCustomer(id: any) {
    return this.http.delete('http://localhost:8080/spring_mvc_hibernate_template/customer/delete/' + id);
  }

  addService(serviceName: string) {
    const body = {
      skill : serviceName
    }
    const headers = new Headers({'Content-Type' : 'application/json'});
    const requestOptions = new RequestOptions({headers:headers});
    return this.http.post('http://localhost:8080/spring_mvc_hibernate_template/admin/addService', body, requestOptions);
  }

  getFeedbacks() {
    return this.http.get('http://localhost:8080/spring_mvc_hibernate_template/admin/feedbackList');
  }

  getOrders(){
    return this.http.get('http://localhost:8080/spring_mvc_hibernate_template/admin/orders');
  }

}


