export function testRestParameters(){
    function userFriends(uname,...friends){
        console.log("Username : ",uname," Friends List : ",friends);
    }
    userFriends("Ekta","a","b","c");
}