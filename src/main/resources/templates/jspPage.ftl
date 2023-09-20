<#import "macros/base.ftl" as b>
<#import "macros/person-info.ftl" as pi>

<@b.base "Jsp Page">
    <#list result as person>
        <@pi.person_info person/>
        <h1>----------------------</h1>
    </#list>
</@b.base>