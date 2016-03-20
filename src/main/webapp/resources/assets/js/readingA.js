function ageBtn(id){
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
function readBtn() {
    document.getElementById('1').classList.remove("btn-primary");
    document.getElementById('1').classList.add("btn-default");
    document.getElementById('2').classList.remove("btn-default");
    document.getElementById('2').classList.add("btn-primary");
}
function watchBtn() {
    document.getElementById('1').classList.remove("btn-default");
    document.getElementById('1').classList.add("btn-primary");
    document.getElementById('2').classList.remove("btn-primary");
    document.getElementById('2').classList.add("btn-default");
}
function add_input()
{
    var new_input=document.createElement('div');
    new_input.innerHTML='<br>Subject №'+document.getElementById('inputs').getElementsByTagName('div').length+1+'<br><input name="my_input">';
    document.getElementById('inputs').appendChild(new_input);
}
function del_input()
{
    document.getElementById('inputs').removeChild(document.getElementById('inputs').getElementsByTagName('div')[document.getElementById('inputs').getElementsByTagName('div').length-1])
}