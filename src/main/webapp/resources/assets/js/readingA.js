new function ageBtn(id){
        if (id == 4){
            document.getElementById('4').classList.remove("btn-default").add("btn-primary");
            document.getElementById('5').classList.remove("btn-primary").add("btn-default");
            document.getElementById('6').classList.remove("btn-primary").add("btn-default");
            document.getElementById('7').classList.remove("btn-primary").add("btn-default");
        }
        if (id == 5){
            document.getElementById('5').classList.remove("btn-default").add("btn-primary");
            document.getElementById('4').classList.remove("btn-primary").add("btn-default");
            document.getElementById('6').classList.remove("btn-primary").add("btn-default");
            document.getElementById('7').classList.remove("btn-primary").add("btn-default");
        }
        if (id == 6){
            document.getElementById('6').classList.remove("btn-default").add("btn-primary");
            document.getElementById('4').classList.remove("btn-primary").add("btn-default");
            document.getElementById('5').classList.remove("btn-primary").add("btn-default");
            document.getElementById('7').classList.remove("btn-primary").add("btn-default");
            }
        if (id == 7){
            document.getElementById('7').classList.remove("btn-default").add("btn-primary");
            document.getElementById('4').classList.remove("btn-primary").add("btn-default");
            document.getElementById('5').classList.remove("btn-primary").add("btn-default");
            document.getElementById('6').classList.remove("btn-primary").add("btn-default");
            }
        }
new function readBtn() {
    document.getElementById('1').classList.remove("btn-primary");
    document.getElementById('1').classList.add("btn-default");
    document.getElementById('2').classList.remove("btn-default");
    document.getElementById('2').classList.add("btn-primary");
}
new function watchBtn() {
    document.getElementById('1').classList.remove("btn-default");
    document.getElementById('1').classList.add("btn-primary");
    document.getElementById('2').classList.remove("btn-primary");
    document.getElementById('2').classList.add("btn-default");
}
function addline()
{
    c++;
    s=document.getElementById('table').innerHTML;
    s=s.replace(/[\r\n]/g,'');
    re=/(.*)(<tr id=.*>)(<\/table>)/gi;
    s1=s.replace(re,'$2');
    s2=s1.replace(/\[\d+\]/gi,'['+c+']');
    s2=s2.replace(/(rmline\()(\d+\))/gi,'$1'+c+')');
    s=s.replace(re,'$1$2'+s2+'$3');
    document.getElementById('table').innerHTML=s;
    return false;
}