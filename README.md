# bITHackaton2018

Input:
```
{ 
	"currentLocation": { 
		"type": "Point", 
		"coordinates": [10, 10] 
	},

	"items": "Butter,Waschmittel"
}
```

Output:
```
{
    "imageBase64": "DUMMY",
    "shoppingItems": [
        {
            "name": "Butter",
           	"description": "Echt Bayrisch",
           	"quantity": "250 g"
        },
        {
            "name": "Waschmittel",
            "description": "Wäscht Weiss",
            "quantity": "500 ml"
        }
    ]
}
```