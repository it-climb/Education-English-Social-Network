var diffId = 0;
var easy = 'easy';
var medium = 'medium';
var hard = 'hard';

function add_input()
{

    var new_input=document.createElement('div');
    new_input.innerHTML='<input type="text" value="" class="form-control" placeholder="Subject Title" name="subject">' +
        '<input type="hidden" value="easy" id="diff'+diffId+'" name="subjectDifficult">';
    document.getElementById('inputs').appendChild(new_input);

    var new_btns=document.createElement('div');
    new_btns.innerHTML='<button type="button" id="easy'+diffId+'" class="btn btn-primary" "> Easy </button>' +
        '<button type="button" id="medium'+diffId+'" class="btn btn-default"> Normal </button>' +
        '<button type="button" id="hard'+diffId+'" class="btn btn-default"> Hard </button>';
    document.getElementById('btns').appendChild(new_btns);
    document.getElementById('easy'+diffId+'').setAttribute('onclick', 'changeDiff('+diffId+', easy)');
    document.getElementById('medium'+diffId+'').setAttribute('onclick', 'changeDiff('+diffId+', medium)');
    document.getElementById('hard'+diffId+'').setAttribute('onclick', 'changeDiff('+diffId+', hard)');
    diffId++;
}
function del_input()
{
    document.getElementById('inputs').removeChild(document.getElementById('inputs').getElementsByTagName('div')[document.getElementById('inputs').getElementsByTagName('div').length-1]);
    document.getElementById('btns').removeChild(document.getElementById('btns').getElementsByTagName('div')[document.getElementById('btns').getElementsByTagName('div').length-1]);
    diffId--;
}



function changeDiff(diffId, diff){
    document.getElementById('diff'+diffId+'').value = diff;
    document.getElementById('easy'+diffId+'').classList.remove('btn-primary');
    document.getElementById('easy'+diffId+'').classList.add('btn-default');
    document.getElementById('medium'+diffId+'').classList.remove('btn-primary');
    document.getElementById('medium'+diffId+'').classList.add('btn-default');
    document.getElementById('hard'+diffId+'').classList.remove('btn-primary');
    document.getElementById('hard'+diffId+'').classList.add('btn-default');
    document.getElementById(''+diff+diffId+'').classList.remove('btn-default');
    document.getElementById(''+diff+diffId+'').classList.add('btn-primary');
}