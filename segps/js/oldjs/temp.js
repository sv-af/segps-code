// D3 visualization code 
var width = 800,
    height = 600;
var linkedByIndex = {};

var svg = d3.select("#visualization")
    .append("svg")
    .attr("width", width)
    .attr("height", height);

var container = svg.append("g")
    .attr("id", "container");

//var nodes = {};
//var links = {};

d3.csv("data/ProjectSecurityVulnerabilities.csv", function(error, dataNodes){
	d3.csv("data/ProjectSecurityVulnerabilities.csv", function(error, dataLinks){
		if(error){
			console.log(error);
		} else{
			console.log(dataNodes);
			//Hand CSV data off to global var,
    			//so it's accessible later.
    			var nodes = map2node(dataNodes);
			dataLinks.forEach(function(link) {
				link.source = nodes[link.Project];
				link.target = nodes[link.Vulnerability];
			});
			//links = this.dataLinks;
    			//Generate Graph
			drawGraph(nodes,dataLinks);
		}
	});
});

function neighboring(id_a, id_b) {
  return linkedByIndex[id_a + "," + id_b] || linkedByIndex[id_b + "," + id_a];
}

function map2node(data) {
	var mappingarray = new Array();
	for (var i = 0; i < data.length; i++) {
		var node = data[i];
		mappingarray[node.id] = node;
	}
	return mappingarray;
}

function drawGraph(nodes, links){
	
	//define a scale for color mapping
	var colormapping = d3.scale.ordinal()
	.domain([0,nodes.length])
	.range(['#A700E6','#D95B96','#F4DA88','#22C1BE','#F24957','#DBEF91','#CF8EE8','#FF9B58','#B8FFC4','#91AEFF','#E873D3','#CCB298']);
		
	//create label node tooltip
	var tooltip = d3.select("body").append("div")
	.attr("class", "tooltip")
	.style("opacity", 1e-6);

	//graph force directed layout algorithm
	var force = d3.layout.force()
	.nodes(nodes)
	.links(links)
	.gravity(0.2)
	.charge(-1500)
	.friction(0.8)
	.size([width, height])
	.linkDistance(200);
	
	force.start();

        //add zoom and pan behavior
	var panrect = rq1.append("rect")
	.attr("width", width)
	.attr("height", height)
	.style("fill", "none")
	.style("pointer-events", "all");
	
        var zoom = d3.behavior.zoom()
	 .scaleExtent([1, 10])
	 .on("zoom", function() {
    	 container.attr("transform", "translate(" + d3.event.translate + ")scale(" + d3.event.scale + ")");
     });

	
	svg.call(zoom);

	//links
	var link = container.selectAll(".line")
	.data(links)
	.enter()
	.append("line")
	.attr("stroke-width",4)
//	.attr("stroke-width",function (d) { return linethickness(d.value); })
	.style("stroke", "gray");

	links.forEach(function(d) {
	  linkedByIndex[d.source.id + "," + d.target.id] = 1;
	  linkedByIndex[d.source.id + "," + d.source.id] = 1;
	  linkedByIndex[d.target.id + "," + d.target.id] = 1;
	});

	//label nodes
	var labelnode = container.selectAll("circle.labelnode")
	.data(nodes)
	.enter().append("g")
	.attr("class", "labelnode")
	.call(force.drag);
	
	var circle = labelnode.append("svg:circle")
	.attr("r", 20)
	.attr("fill", function (d,i) {return d3.rgb(colormapping(i)); });
	

	circle.on("mousemove", function(d, index, element) {
		labeltooltip.selectAll("p").remove();
		labeltooltip.style("left", (d3.event.pageX+15) + "px")
			    .style("top", (d3.event.pageY-10) + "px");
		labeltooltip.append("p").attr("class", "tooltiptext").html("<span>label: </span>" + d.name);
		labeltooltip.append("p").attr("class", "tooltiptext").html("<span>number of issues: </span>" + d.Score);
	}); 

	circle.on("mouseover", function(d) {
		labeltooltip.transition()
          		.duration(500)
          		.style("opacity", 1);
		link.style('stroke', function(l) {
			if (d === l.source || d === l.target)
			  return d3.rgb('#9E00D9');
			else
			  return 'gray';
			});
		link.style('opacity', function(o) {
			return o.source === d || o.target === d ? 1 : 0;
		});
		labelnode.style("opacity", function(o) {
			if (o.id != d.id)
				return neighboring(d.id, o.id) ? 1 : 0;
		});
          });

	circle.on("mouseout", function(d) {
		labeltooltip.transition()
          		.duration(500)
          		.style("opacity", 1e-6);
		link.style('stroke', 'gray');
		link.style('opacity', 1);
		labelnode.style("opacity", 1);  
        });

	var circletext = labelnode.append("svg:text")
	.text(function(d) {return d.name;})
	.attr("class","labelText");

	force.on("tick", function() {
		link.attr("x1", function(d) { return d.source.x; })
		.attr("y1", function(d) { return d.source.y; })
		.attr("x2", function(d) { return d.target.x; })
		.attr("y2", function(d) { return d.target.y; });
		var r = +circle.attr("r");
		circle.attr("cx", function(d) { return d.x = Math.max(r + 35, Math.min(w1 - r - 35, d.x)); })
		.attr("cy", function(d) { return d.y = Math.max(r + 35, Math.min(h1 - r - 35, d.y)); });
		circletext.attr("x", function(d) { return d.x-25; });
		circletext.attr("y", function(d) { return d.y-25;});
	});
}
