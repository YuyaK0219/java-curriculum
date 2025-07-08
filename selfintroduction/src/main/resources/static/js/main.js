document.addEventListener('DOMContentLoaded', function () {
  const tooltip = document.getElementById('tooltip');

  window.showTooltip = function (event, element) {
    const desc = element.getAttribute('data-description');
    if (!desc) return;

    tooltip.textContent = desc;

    const mouseX = event.clientX;
    const mouseY = event.clientY;

    tooltip.style.top = `${mouseY + 15}px`;
    tooltip.style.left = `${mouseX + 15}px`;

    tooltip.classList.add('visible');
  };

  window.hideTooltip = function () {
    tooltip.classList.remove('visible');
  };
});