// After the API loads, call a function to enable the search box.

$("#search-button").click(function(){
		gapi.client.setApiKey("AIzaSyA2qoWTghwsr5fr4O91cglYuo3GzU5yD4M");
		gapi.client.load('youtube', 'v3',function(){});
		try{
			setTimeout(function(){ search() }, 500);	
		}catch(e){}
		
});

function handleAPILoaded() {
  $('#search-button').attr('disabled', false);
}

// Search for a specified string.
function search() {
  var q = $('#query').val();
  var request = gapi.client.youtube.search.list({
    q: q,
    part: 'snippet'
  });

  request.execute(function(response) {
    var item = {};
    item = response.result;
    console.log(item.items);
    
    var ul = document.createElement("ul");
    ul.classList.add( 'thumbnails' );    
    ul.style="list-style:none";
    
    for(var i=0;i<item.items.length;i++){
    	var li = document.createElement("li");
    	li.classList.add( 'span4' );
    	
    	var div = document.createElement("div");
    	div.classList.add( 'thumbnail' );
    	
    	var a = document.createElement("a");
    	a.href="javascript:playVideo('"+item.items[i].id.videoId+"')";
    	
    	var img = document.createElement("img");
    	img.src = item.items[i].snippet.thumbnails.medium.url;
    	
    	var h4 = document.createElement("h4");
    	h4.innerHTML = item.items[i].snippet.title;    	
    	
    	if($("#search-container").children().length!=0){
    		$("#search-container").children().remove();
    	}
    	
    	$('#search-container').append(ul);
    	ul.append(li);
    	li.append(div);
    	div.append(a);
    	a.append(img);
    	a.append(h4);
    }
    
  });
}

function playVideo(videoId){	
		
	if($("#video").length!=0){
		$("#video").remove();
	}
	var video = document.createElement('iframe');    
	video.id = "video";
	video.width="1100";
	video.height="450";
	video.src="https://www.youtube.com/embed/"+videoId;
	video.frameborder="0";
	video.allowfullscreen;
	
	$('#search-result').append(video);
	
}