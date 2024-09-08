// Function to show/hide lyrics and audio
function toggleLyrics(clickedTitle) {
    // Get the corresponding lyrics and audio elements
    const lyrics = clickedTitle.nextElementSibling;
    const audio = lyrics.nextElementSibling;

    // Hide all other lyrics and audios
    const allLyrics = document.querySelectorAll('.lyrics');
    const allAudios = document.querySelectorAll('.play-audio');

    // Hide all other rhymes' lyrics and audio
    allLyrics.forEach(lyric => lyric.style.display = 'none');
    allAudios.forEach(aud => aud.style.display = 'none');

    // Toggle display of current rhyme's lyrics and audio
    if (lyrics.style.display === 'block') {
        lyrics.style.display = 'none';
        audio.style.display = 'none';

    } else {
        lyrics.style.display = 'block';
        audio.style.display = 'block';
    }
}