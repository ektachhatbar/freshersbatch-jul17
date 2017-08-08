export function testCollections(){
    let m_users=new Set();
    m_users.add("um1");
    m_users.add("um2");
    m_users.add("um3");

    let s_users=new Set();
    s_users.add("us1");
    s_users.add("us2");
    s_users.add("us3");

    let m_messages=["m_msg1","m_msg2","m_msg3","m_msg4"];
    let s_messages=["s_msg1","s_msg2","s_msg3","s_msg4"];

    let map1=new Map();
    map1.set('music_room',m_messages);

    let map2=new Map();
    map2.set('sports_room',s_messages);

    let m_arr1=[...map1.values()];
    let m_arr2=[...map2.values()];
    let u_arr1=[...m_users];
    let u_arr2=[...s_users];
    
    console.log(map1.entries());
    console.log(map2.entries());
    console.log(u_arr1);
    console.log(u_arr2);
}