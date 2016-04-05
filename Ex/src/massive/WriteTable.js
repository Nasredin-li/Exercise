
var a=y;
var b=x;
var table = "<table id=\"tbl\" style=\"border: 2px solid rgb(30, 70, 240);\">";
printTable();
function printTable(){	
		for (i = 0; i < a * b;) {			
			for (y2 = 0; y2 < a; y2++) {				
				table= table + '<tr>';
				for (x2 = 0; x2 < b; x2++) {
					table= table + '<td id=\"' + i + '\"'
							+ ' style=\"border: 2px solid rgb(30, 70, 240); width: 35px;height: 35px;';

					if (data[i][0] != 0) {
						table= table +'border-top: none;';
					}
					if (data[i][1] != 0) {
						table= table +'border-bottom: none;';
					}
					if (data[i][2] != 0) {
						table= table +'border-left: none;';
					}
					if (data[i][3] != 0) {
						table= table +'border-right: none;';
					}
					table= table +'\">';
					pasteGift();
					table= table +'</td>';

					i++;
				}
				table= table +'</tr>';
			}
			table= table +'</table>';
		}
	}


function pasteGift(){
		for(k=0; k<gift.length; k++){
		if(gift[k]!=i){
			table= table +'&nbsp;';
		}else {
			table= table + "<IMG src=\"./new-year-composition9.gif\">";
		}
	}
}
document.getElementById("maze").innerHTML= table;

var pointerAndGift = "<table width=\"500\" border=\"3\" align=\"center\" bordercolor=\"#FFFFFF\" id=\"more\"><tr><td width=\"200\" align=\"center\"><div><button type=\"button\" onclick=\"left()\"><IMG src=\"./StrelkaL.gif\" ></button><button type=\"button\" onclick=\"top()\"><IMG src=\"./Strelka.gif\"></button><button type=\"button\" onclick=\"right()\"><IMG src=\"./StrelkaR.gif\" ></button><button type=\"button\" onclick=\"bottom()\"><IMG src=\"./StrelkaB.gif\" ></button></div></td>";
tableForGifts();
function tableForGifts(){
	for (f = 0; f < gift.length; f++) {
			pointerAndGift = pointerAndGift + "<td width=\"45\" align=\"center\" valign=\"middle\"><div id=\"oneGift" + f + "\">		</div></td>";
			}
}
document.getElementById("pointerAndGifts").innerHTML= pointerAndGift;		
/*alert(printTable());*/