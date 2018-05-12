# Driver Service Description

__Base URL__: `/rising-sun/driver`

## Insert a Driver

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
## Fetch all Drivers

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
        "id": 2,
        "name": "driver2",
        "country": "br"
    }
]
```