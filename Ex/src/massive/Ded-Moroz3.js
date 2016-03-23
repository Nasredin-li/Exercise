

var position=0;
document.getElementById(position).innerHTML="<IMG src=\"./Ded-Moroz.gif\">";
function giftCount(position, cadeau, gift){
	for(h=0; h < gift.length; h++){
		if(position==gift[h]){
			cadeau++;
alert(cadeau);
			var c="oneGift"+h.toString();
			document.getElementById(c).innerHTML="<IMG src=\"./new-year-composition9.gif\">";
		}
	}
}

function right()
{
if(((position+1)%x)!=0 && data[position][3]==1)
{
document.getElementById(position).innerHTML="";
position = position + 1;
document.getElementById(position).innerHTML="<IMG src=\"./Ded-Moroz.gif\">";
}
}
function left()
{
if(((position+1)%x)!=1&& data[position][2]==1){
document.getElementById(position).innerHTML="";
position = position - 1;
document.getElementById(position).innerHTML="<IMG src=\"./Ded-Moroz.gif\">";
}
}
function top()
{
if(position>(x-1)&& data[position][0]==1)
{
document.getElementById(position).innerHTML="";
position = position - x;
document.getElementById(position).innerHTML="<IMG src=\"./Ded-Moroz.gif\">";
}
}
function bottom()
{
if(position<(x*y-x)&& data[position][1]==1)
{
document.getElementById(position).innerHTML="";
position = position + x;
document.getElementById(position).innerHTML="<IMG src=\"./Ded-Moroz.gif\">";
}
}

document.onkeydown = function checkKeycode(event)
{
var keycode;
if(!event) var event = window.event;
if (event.keyCode) keycode = event.keyCode; 
else if(event.which) keycode = event.which; 
var cadeau=0;

switch (keycode)
{
case 37: 
left(); 
giftCount(position,cadeau,gift);
break ;
case 38: 
top(); 
giftCount(position,cadeau,gift);
break ;
case 39: 
right(); 
giftCount(position,cadeau,gift);
break ;
case 40: 
bottom(); 
giftCount(position,cadeau,gift);

break;

}
}
