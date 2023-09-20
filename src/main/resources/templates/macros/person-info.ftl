<#macro person_info person>
    <h2>Person id: ${person.id} </h2>
    <h2>Person first name: ${person.firstName} </h2>
    <h2>Person second name: ${person.secondName} </h2>
    <h2>Person age: ${person.age} </h2>
    <h2>Person married status: ${person.isMarried?string} </h2>
    <h2>Person created: ${person.created} </h2>
</#macro>