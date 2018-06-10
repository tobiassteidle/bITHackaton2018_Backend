# bITHackaton2018

#### Rest

##### Abfrage aller Artikel
```
HTTP-GET: http://localhost:8080/salesitems
```
Output:
```
[
    {
        "name": "Butter",
        "description": "Wirklich Fettig",
        "point": {
            "type": "Point",
            "coordinates": [
                5,
                4
            ]
        }
    },
    {
        "name": "Milch",
        "description": "3,5% Fett",
        "point": {
            "type": "Point",
            "coordinates": [
                3,
                10
            ]
        }
    }
]
```

##### Navigation nach Einkaufsliste:
```
HTTP-POST: http://localhost:8080/navigate
```
Request-Body:
```
{ 
	"currentLocation": { 
		"type": "Point", 
		"coordinates": [10, 10] 
	},

	"items": "Butter,Milch"
}
```

Output:
```
{
    "imageBase64": "DUMMY",
    "shoppingItems": [
        {
            "name": "Butter",
           	"description": "Wirklich Fettig",
           	"quantity": "250 g"
        },
        {
            "name": "Milch",
            "description": "3,5% Fett",
            "quantity": "1 l"
        }
    ]
}
```
