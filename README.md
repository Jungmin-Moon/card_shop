# Card Shop
Following along and building a card shop similar to example shown in text.

The Text I am following is creating a book shop but I decided to create a card shop instead.

| Endpoint | HTTP Method | Request Body | Status | Response Body | Description |
| :------: | :------: | :------: | :------: | :------: | :------: |
| /cards   | GET         |              | 200    | Card[]        | Gets all cards in catalog |
| /cards   | POST        | Card         | 201    | Card          | Adds a card to the catalog |
| /cards/{name} | GET    |              | 200    | Card          | Get the card with the specific name |
|          |             |              | 404    |               | No card with that name exists in the catalog |
| /cards/{name} | POST   | Card         | 200    | Card          | Update card information with given name |
|          |             |              | 201    | Card          | Create a new card with the given name |
| /cards/{name} | DELETE |              | 204    |               | Delete card with given name |
