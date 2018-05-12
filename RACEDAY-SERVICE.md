# RaceDay Service Description

__Base URL__: `/rising-sun/race-day`

## Insert a Race Day

__Method__: POST

__Data Params__: 
```json
{
  "date": [date],
  "lobbyHost": [string],
  "eventFormat": [string : 'SOLO' | 'TEAM' | 'ENDURANCE_SOLO' | 'ENDURANCE_TEAM'],
  "season": [integer] (Optional)
}
```

__Sample Call__:
```javascript 
$.ajax({
  url: "/rising-sun/race-day",
  type : "POST",
  dataType: "json",
  data : { 
    date : "2018-05-12T09:00:00.000Z",
    lobbyHost: "host",
    eventFormat: "SOLO",
  },
  success : function(r) {
    console.log(r);
  }
});
```

## Update a Race Day

__Method__: PUT

__URL Params__:

* Required: `raceDayId=[integer]`

__Data Params__: 
```json
{
  "date": [date],
  "lobbyHost": [string],
  "eventFormat": [string : 'SOLO' | 'TEAM' | 'ENDURANCE_SOLO' | 'ENDURANCE_TEAM'],
  "season": [integer] (Optional)
}
```

__Sample Call__:
```javascript 
$.ajax({
  url: "/rising-sun/race-day/1",
  type : "PUT",
  dataType: "json",
  data : { 
    date : "2018-05-12T09:00:00.000Z",
    lobbyHost: "host",
    eventFormat: "SOLO"
  },
  success : function(r) {
    console.log(r);
  }
});
```

## Delete a Race Day

__Method__: DELETE

__URL Params__:

* Required: `raceDayId=[integer]`

__Sample Call__:
```javascript 
$.ajax({
  url: "/rising-sun/race-day/1",
  type : "DELETE",
  success : function(r) {
    console.log(r);
  }
});
```

## Fetch One RaceDays

__Method__: GET

__URL Params__:

* Required: `raceDayId=[integer]`

__Sample Call__:
```javascript 
$.ajax({
  url: "/rising-sun/race-day/1",
  type : "GET",
  success : function(r) {
    console.log(r);
  }
});
```

__Success Response Content__:
```json
{
    "id": 1, 
    "date" : "2018-05-05T09:00:00.000Z",
    "lobbyHost": "host",
    "eventFormat": "SOLO"
}
```

## Fetch All RaceDays

__Method__: GET

__Sample Call__:
```javascript 
$.ajax({
  url: "/rising-sun/race-day",
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
        "date" : "2018-05-05T09:00:00.000Z",
        "lobbyHost": "host",
        "eventFormat": "SOLO"
    },
    {
        "id": 1, 
        "date" : "2018-05-12T09:00:00.000Z",
        "lobbyHost": "host",
        "eventFormat": "SOLO"
    }
]
```