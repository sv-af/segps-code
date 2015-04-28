var width = 800,
    height = 600;

// Parse the date / time
var parseDate = d3.time.format("%d-%b-%y").parse;
var formatTime = d3.time.format("%e %B");// Format tooltip date / time

//Visualization container
var svg = d3.select("#vRQ1")
    .append("svg")
    .attr("width", width)
    .attr("height", height);
    //.append("svg:g");

var force = d3.layout.force()
    .gravity(0.2)
    .distance(200)
    .charge(-1500)
    .size([width, height]);

//Getting the data from CSV file
d3.csv("data/vRQ2_.csv", function(errors,links) {

  var nodesByName = {};

  // Create nodes for each unique source and target.
  links.forEach(function(link) {
    link.source = nodeByName(link.Project);
    link.target = nodeByName(link.Super);
  });

  // Extract the array of nodes from the map by name.
  var nodes = d3.values(nodesByName);
  
  // Start the force layout.
  force
      .nodes(nodes)
      .links(links)
      .on("tick", tick)
      .start();

//add zoom and pan behavior
   var panrect = svg.append("rect")
	.attr("width", width)
	.attr("height", height)
	.style("fill", "none")
	.style("pointer-events", "all");
 //sub-container for visualizing the nodes and links.
 var container = svg.append("g")
    .attr("id", "container");

  //define a scale for color mapping
  var colormapping = d3.scale.ordinal()
      .domain([0,nodes.length])
      .range(['#A700E6','#F4DA88','#CF8EE8','#FF9B58','#B8FFC4','#91AEFF','#E873D3','#CCB298']);
	
  //create label node tooltip
  var labeltooltip = d3.select("body").append("div")
    .attr("class", "labeltooltip")
    .style("opacity", 1e-6);

  //create zoom 
  var zoom = d3.behavior.zoom()
	 .scaleExtent([1, 10])
	 .on("zoom", function() {
    	 container.attr("transform", "translate(" + d3.event.translate + ")scale(" + d3.event.scale + ")");
     }); 
  svg.call(zoom);

  //assigne the links to the graph
  var link = container.selectAll(".link")
      .data(links)
      .enter()
      .append("line")
      .attr("stroke-width",3)
      .style("stroke", "gray");

  // assign the node circles to the graph
  var node = container.selectAll(".node")
      .data(nodes)
      .enter()
      .append("g")
      .attr("class", "node")
      .call(force.drag);

  var circle = node.append("circle")
      .attr("r", function(d){
		var str = d.name;
		if(str.indexOf("CVE-")>=0){
			return 11;
		}else{
			return 40;
		}
	})
      .attr("fill", function (d,i) {
		var str = d.name;
		if(str.indexOf("CVE-")>=0)
			return d3.rgb(220,20,60);
		if(d === i.target) 
			return d3.rgb(255,20,147);  
		else 
			return d3.rgb(colormapping(i));
		
	
	});
  
  circle.on("mousemove", function(d) {
  	var str = d.name;
//	console.log(d.name);
	if(str.indexOf("CVE-")>=0){
		var url = '<a  href= "https://web.nvd.nist.gov/view/vuln/detail?vulnId='+d.name+'" target="_blank" >' +d.name +"</a>"
		labeltooltip.selectAll("p").remove();
		labeltooltip.style("left", (d3.event.pageX) + "px")
                    .style("top", (d3.event.pageY-10) + "px");

		labeltooltip.append("p").attr("class", "tooltiptext").html("<span><b>Affected By: </span></b>" + url);

	} else{
		labeltooltip.selectAll("p").remove();
		labeltooltip.transition()
          		.duration(500)
                        .style("opacity", 1e-6);
	}
   }); 

 circle.on("mouseover", function(d) {

    	labeltooltip.transition()
          .duration(500)
          .style("opacity", 1);
	link.style('stroke', function(l) {
		if (d === l.source || d === l.target)
		    return d3.rgb('#C20606');
		else
		  return 'gray';
	});
	link.style('opacity', function(o) {
		return o.source === d || o.target === d ? 1 : 0;
	});
		
    }); 

 circle.on("mouseout", function(d) {
  	link.style('stroke', 'gray');
	link.style('opacity', 1);
	node.style("opacity", 1);  
    });

  // create nodes (circles) names
  var circletext = node.append("svg:text")
	.text(function(d) {return d.name;})
	.attr("class","labelText");
  function tick() {
    link.attr("x1", function(d) { return d.source.x; })
        .attr("y1", function(d) { return d.source.y; })
        .attr("x2", function(d) { return d.target.x; })
        .attr("y2", function(d) { return d.target.y; });

    circle.attr("cx", function(d) { return d.x; })
        .attr("cy", function(d) { return d.y; });
    circletext.attr("x", function(d) { return d.x-25; });
    circletext.attr("y", function(d) { return d.y-25;});
  }

   // handel the mouse event click to 
   panrect.on("click", function(d){
	labeltooltip.transition()
       		.duration(500)
                .style("opacity", 1e-6);
   });

//assign the data to the nodes and links
function nodeByName(name,Super) {
    return nodesByName[name] || (nodesByName[name] = {name: name,Super: Super});
  }

});

 
