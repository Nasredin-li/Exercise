var position=0;
var step=0;
var cadeau=0;
var p = 0;
var t = 0;
var t2 = 0;
document.getElementById(position).innerHTML="<IMG src=\"./Ded-Moroz.gif\">";

function getTimePlay(){	
	p = new Date().getTime();

	return p;
}
function giftCount(position, cadeau, gift){
	
	for(h=0; h < gift.length; h++){
		if(position==gift[h]){	
			var c="oneGift"+h.toString();
			if(document.getElementById(c).innerHTML!="<IMG src=\"./new-year-composition9.gif\">"){
				document.getElementById(c).innerHTML="<IMG src=\"./new-year-composition9.gif\">";
				chekGift();
			}  
			
		
		}
	}
}
function difference(){
	d= (t2-t)/1000;
	alert("Your play time is "+d+ " second!");
}
function chekGift(){
	cadeau+=1;
	if(cadeau==gift.length){
		t2 = getTimePlay();
		difference(); 
		if(confirm("You vant else?")==true){
			location.assign("Maze2.htm");
			//assign
		}
	}
}
function countStep(){
	step+=1;
	document.getElementById("step").innerHTML=step;
	if(step==1) {
		t = getTimePlay();
	}
}
function right()
{
if(((position+1)%x)!=0 && data[position][3]==1)
{
document.getElementById(position).innerHTML="&nbsp;";
position = position + 1;
document.getElementById(position).innerHTML="<IMG src=\"./Ded-Moroz.gif\">";
giftCount(position,cadeau,gift);
countStep();
//window.open("http://www.mail.ru/");
}
}
function left()
{
if(((position+1)%x)!=1&& data[position][2]==1){
document.getElementById(position).innerHTML="&nbsp;";
position = position - 1;
document.getElementById(position).innerHTML="<IMG src=\"./Ded-Moroz.gif\">";
giftCount(position,cadeau,gift);
countStep();
}
}
function top()
{
if(position>(x-1)&& data[position][0]==1)
{
document.getElementById(position).innerHTML="&nbsp;";
position = position - x;
document.getElementById(position).innerHTML="<IMG src=\"./Ded-Moroz.gif\">";
giftCount(position,cadeau,gift);
countStep();
}
}
function bottom()
{
if(position<(x*y-x)&& data[position][1]==1)
{
document.getElementById(position).innerHTML="&nbsp;";
position = position + x;
document.getElementById(position).innerHTML="<IMG src=\"./Ded-Moroz.gif\">";
giftCount(position,cadeau,gift);
countStep();
}
}

document.onkeydown = function checkKeycode(event)
{
var keycode;
if(!event) var event = window.event;
if (event.keyCode) keycode = event.keyCode; 
else if(event.which) keycode = event.which; 


switch (keycode)
{
case 37: 
left(); 

break ;
case 38: 
top(); 

break ;
case 39: 
right(); 

break ;
case 40: 
bottom(); 

break;
}
}
