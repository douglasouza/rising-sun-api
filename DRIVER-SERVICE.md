# Driver Service Description

__Base URL__: `/rising-sun/driver`

___

* __Insert a Driver__

__Method__: POST

__URL Params__: 
* Required:  `driverGtsId=[integer]`

__Sample Call__:
```javascript 
$.ajax({
  url: "/rising-sun/driver?driverGtsId=10",
  type : "POST",
  success : function(r) {
    console.log(r);
  }
});
```
___

* __Fetch all Drivers__

__Method__: GET

__Sample Call__:
```javascript 
$.ajax({
  url: "/rising-sun/driver",
  type : "GET",
  success : function(r) {
    console.log(r);
  }
});
```

__Success Response Content__:
```json
[
    {
        "id": 1,
        "name": "driver1",
        "country": "us"
    },
    {
        "id": 1,
        "name": "driver1",
        "country": "br"
    }
]
```