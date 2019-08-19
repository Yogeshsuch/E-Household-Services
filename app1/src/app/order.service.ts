import { Injectable } from '@angular/core';
import { RequestOptions, Http, Headers } from '@angular/http';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  constructor(private http : Http) { }

  post(address,eDate,eTime,issue,service,mobNumber){
    const cid = sessionStorage['user'];
    console.log(cid);
    const body = {
      address:address,
      expectDate:eDate,
      expectTime:eTime,
      issue:issue,
      service:service,     
      mobileNo:mobNumber,
      cid:cid
    }
    console.log(body);
    const headers = new Headers({'Content-Type' : 'application/json'});
    const requestOptions = new RequestOptions({headers:headers})

    return this.http.post('http://localhost:8080/spring_mvc_hibernate_template/order/book', body, requestOptions);
  }

  getDetails(id){
    console.log(id);
      return this.http.get('http://localhost:8080/spring_mvc_hibernate_template/customer/getDetails/' + id);
  }

  getNewOrders(skill:String){
    console.log(skill);
    const body = {
      skill:skill
    }
    console.log(body);
    const headers = new Headers({'Content-Type' : 'application/json'});
    const requestOptions = new RequestOptions({headers:headers})
    return this.http.post('http://localhost:8080/spring_mvc_hibernate_template/order/orders',body,requestOptions);
  }

  acceptOrder(oid, fid){
    console.log(oid);

    const body = {
      oid:oid,
      pid:fid
    }
    console.log(body);
    const headers = new Headers({'Content-Type' : 'application/json'});
    const requestOptions = new RequestOptions({headers:headers})
    return this.http.post('http://localhost:8080/spring_mvc_hibernate_template/order/accept',body,requestOptions);
  }

  acceptedOrders(fid){
    const body = {
      pid:fid
    }
    console.log(body);
    const headers = new Headers({'Content-Type' : 'application/json'});
    const requestOptions = new RequestOptions({headers:headers})
    return this.http.post('http://localhost:8080/spring_mvc_hibernate_template/order/acceptedOrders',body,requestOptions);
  }

  orderCompleted(oid){
    const body = {
      oid:oid
    }
    console.log(body);
    const headers = new Headers({'Content-Type' : 'application/json'});
    const requestOptions = new RequestOptions({headers:headers})
    return this.http.post('http://localhost:8080/spring_mvc_hibernate_template/order/orderComplete',body,requestOptions);
  }

  sendEmail(id){
    const body = {
      oid:id
    }
    console.log(body);
    const headers = new Headers({'Content-Type' : 'application/json'});
    const requestOptions = new RequestOptions({headers:headers})
    return this.http.post('http://localhost:8080/spring_mvc_hibernate_template/order/orderComplete',body,requestOptions);
  }

  getOrders(){
    return this.http.get('http://localhost:8080/spring_mvc_hibernate_template/order/allOrders');
  }

  cancelOrder(oid){
    const body = {
      oid:oid
    }
    console.log(body);
    const headers = new Headers({'Content-Type' : 'application/json'});
    const requestOptions = new RequestOptions({headers:headers})
    return this.http.post('http://localhost:8080/spring_mvc_hibernate_template/order/cancelOrder',body,requestOptions);
  }

}
