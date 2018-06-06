$(document).ready(function () {
                 $('#sidebarCollapse').on('click', function () {
                     $('#sidebar').toggleClass('active');
                 });
                 
                 ({
 					url:'agegroup',
 					dataType:'JSON',
 					success: function(result){
 					      google.charts.load('current', {packages:['corechart']});
 					      google.charts.setOnLoadCallback(function(){
 					    	  drawageChart(result);
 					      });

 					}
 				});
 				
 				$.ajax({
 					url:'gendergroup',
 					dataType:'JSON',
 					success: function(result){
 							google.charts.load('current', {packages: ['corechart']});
 					      google.charts.setOnLoadCallback(function(){
 					    	  drawgenderChart(result);
 					      });

 					}
 				});
             });

function drawageChart(result){
         		var data= new google.visualization.DataTable();
         		data.addColumn('string','agegroup');
         		data.addColumn('number', 'patientnumber');
         		var dataArray = [];
         		$.each(result, function(i,obj){
         			dataArray.push([ obj.indicator, obj.value ]);	
         		});
         		data.addRows(dataArray);
         		
         		var options = {
                         'height':300,
                         'chartArea': {'width': '100%', 'height': '80%'},
                         'legend': {'position': 'bottom'},
                         vAxis: {
                             minValue: 0,
                           }
         		};
         		
                 var chart = new google.visualization.PieChart(document.getElementById('chart_div'));
                 chart.draw(data,options); 
         		
         		
         	}
         	
         	function drawgenderChart(result){
         		
         		var dataArray = [];
         		dataArray.push(['gender','number of stroke',{role:'style'}]);
         		$.each(result, function(i,obj){
         			dataArray.push([ obj.element, obj.number, obj.style ]);	
         		});
         		var data= new google.visualization.arrayToDataTable(dataArray);
         		
         		var options = {
                         'height':100,
                         'chartArea': {'width': '100%', 'height': '80%'},
                         'legend': {'position': 'bottom'},
                        };
         		
                 var chart = new google.visualization.ColumnChart(document.getElementById('chart_div1'));
                 chart.draw(data,options); 
         		
         		
         	}