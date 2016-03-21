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
    new_input.innerHTML='<input type="text" value="" class="form-control" placeholder="Subject Title" id="subject№'+document.getElementById('inputs').getElementsByTagName('div').length+'">';
    document.getElementById('inputs').appendChild(new_input);
}
function del_input()
{
    document.getElementById('inputs').removeChild(document.getElementById('inputs').getElementsByTagName('div')[document.getElementById('inputs').getElementsByTagName('div').length-1])
}
function create_list(){
    //console.log("111")
    var listOfSubj = new Array();

    for (var i = 0; i <= document.getElementById('inputs').getElementsByTagName('div').length -1 ; i++){
        //console.log(i,document.getElementById('subject№'+i+'').value);
        var valueOfInput = document.getElementById('subject№'+i+'').value;
        listOfSubj[i] = valueOfInput;
    }
    var name = document.getElementById('nameField').value;
    var text = document.getElementById('textField').value;
    $.ajax({
        type: 'POST',
        url: 'localhost:8080/addReadActivity',
        dataType:"json",
      // data: { text : text },
      // data: { name : name },
        data: { listOfSubj : listOfSubj, text : text, name: name },
        success: function (resp) {
            console.log(resp);
        },
        error:function (err) {
            console.error(err);
        }
    });
    //document.getElementById('10').setAttribute('value', ""+listOfSubj);
}