// ===== CONFIGURACIÓN INICIAL =====
document.addEventListener('DOMContentLoaded', function() {
    // Inicializar todas las funcionalidades
    initNavigation();
    initScrollEffects();
    initAnimations();
    initBackToTop();
    initParallaxEffects();
    initCounterAnimations();
    initTypingEffect();
    initParticleEffects();
    
    console.log('🚀 MisGastos Landing Page cargada exitosamente');
});

// ===== NAVEGACIÓN =====
function initNavigation() {
    const navToggle = document.getElementById('nav-toggle');
    const navMenu = document.getElementById('nav-menu');
    const navLinks = document.querySelectorAll('.nav-link');
    const navbar = document.getElementById('navbar');
    
    // Toggle del menú móvil
    navToggle.addEventListener('click', () => {
        navMenu.classList.toggle('active');
        navToggle.classList.toggle('active');
        document.body.classList.toggle('nav-open');
    });
    
    // Cerrar menú al hacer clic en un enlace
    navLinks.forEach(link => {
        link.addEventListener('click', () => {
            navMenu.classList.remove('active');
            navToggle.classList.remove('active');
            document.body.classList.remove('nav-open');
        });
    });
    
    // Efecto de scroll en navbar
    let lastScrollTop = 0;
    window.addEventListener('scroll', () => {
        const scrollTop = window.pageYOffset || document.documentElement.scrollTop;
        
        // Agregar clase scrolled cuando se hace scroll
        if (scrollTop > 100) {
            navbar.classList.add('scrolled');
        } else {
            navbar.classList.remove('scrolled');
        }
        
        // Ocultar/mostrar navbar en scroll
        if (scrollTop > lastScrollTop && scrollTop > 200) {
            navbar.style.transform = 'translateY(-100%)';
        } else {
            navbar.style.transform = 'translateY(0)';
        }
        
        lastScrollTop = scrollTop;
    });
    
    // Smooth scroll para enlaces internos
    navLinks.forEach(link => {
        link.addEventListener('click', (e) => {
            const href = link.getAttribute('href');
            
            if (href.startsWith('#')) {
                e.preventDefault();
                const target = document.querySelector(href);
                
                if (target) {
                    const offsetTop = target.offsetTop - 80;
                    window.scrollTo({
                        top: offsetTop,
                        behavior: 'smooth'
                    });
                }
            }
        });
    });
    
    // Activar enlace activo según scroll
    window.addEventListener('scroll', updateActiveNavLink);
}

function updateActiveNavLink() {
    const sections = document.querySelectorAll('section[id]');
    const navLinks = document.querySelectorAll('.nav-link');
    
    let current = '';
    
    sections.forEach(section => {
        const sectionTop = section.offsetTop - 100;
        const sectionHeight = section.offsetHeight;
        
        if (window.scrollY >= sectionTop && window.scrollY < sectionTop + sectionHeight) {
            current = section.getAttribute('id');
        }
    });
    
    navLinks.forEach(link => {
        link.classList.remove('active');
        if (link.getAttribute('href') === `#${current}`) {
            link.classList.add('active');
        }
    });
}

// ===== EFECTOS DE SCROLL =====
function initScrollEffects() {
    // Intersection Observer para animaciones
    const observerOptions = {
        threshold: 0.1,
        rootMargin: '0px 0px -50px 0px'
    };
    
    const observer = new IntersectionObserver((entries) => {
        entries.forEach(entry => {
            if (entry.isIntersecting) {
                entry.target.classList.add('animate-fade-in-up');
                observer.unobserve(entry.target);
            }
        });
    }, observerOptions);
    
    // Observar elementos para animación
    const animateElements = document.querySelectorAll(
        '.feature-card, .screenshot-card, .tech-item, .author-card'
    );
    
    animateElements.forEach(el => {
        observer.observe(el);
    });
    
    // Parallax para orbes de fondo
    window.addEventListener('scroll', () => {
        const scrolled = window.pageYOffset;
        const parallaxElements = document.querySelectorAll('.gradient-orb');
        
        parallaxElements.forEach((element, index) => {
            const speed = 0.5 + (index * 0.1);
            element.style.transform = `translateY(${scrolled * speed}px) rotate(${scrolled * 0.1}deg)`;
        });
    });
}

// ===== ANIMACIONES =====
function initAnimations() {
    // Animación de escritura en el título
    const titleElement = document.querySelector('.hero-title .gradient-text');
    if (titleElement) {
        const text = titleElement.textContent;
        titleElement.textContent = '';
        
        let i = 0;
        const typeWriter = () => {
            if (i < text.length) {
                titleElement.textContent += text.charAt(i);
                i++;
                setTimeout(typeWriter, 100);
            }
        };
        
        // Iniciar después de un pequeño delay
        setTimeout(typeWriter, 500);
    }
    
    // Animación de aparición escalonada para badges
    const badges = document.querySelectorAll('.badge');
    badges.forEach((badge, index) => {
        badge.style.opacity = '0';
        badge.style.transform = 'translateY(20px)';
        
        setTimeout(() => {
            badge.style.transition = 'all 0.5s ease';
            badge.style.opacity = '1';
            badge.style.transform = 'translateY(0)';
        }, 800 + (index * 200));
    });
    
    // Animación de hover para feature cards
    const featureCards = document.querySelectorAll('.feature-card');
    featureCards.forEach(card => {
        card.addEventListener('mouseenter', () => {
            card.style.transform = 'translateY(-8px) scale(1.02)';
        });
        
        card.addEventListener('mouseleave', () => {
            card.style.transform = 'translateY(0) scale(1)';
        });
    });
    
    // Animación de pulso para botones
    const buttons = document.querySelectorAll('.btn-primary, .download-btn');
    buttons.forEach(button => {
        button.addEventListener('mouseenter', () => {
            button.style.animation = 'pulse 0.6s ease-in-out';
        });
        
        button.addEventListener('animationend', () => {
            button.style.animation = '';
        });
    });
}

// ===== BOTÓN BACK TO TOP =====
function initBackToTop() {
    const backToTopBtn = document.getElementById('back-to-top');
    
    if (!backToTopBtn) return;
    
    window.addEventListener('scroll', () => {
        if (window.pageYOffset > 300) {
            backToTopBtn.classList.add('visible');
        } else {
            backToTopBtn.classList.remove('visible');
        }
    });
    
    backToTopBtn.addEventListener('click', () => {
        window.scrollTo({
            top: 0,
            behavior: 'smooth'
        });
    });
}

// ===== EFECTOS PARALLAX =====
function initParallaxEffects() {
    const heroSection = document.querySelector('.hero');
    const phoneMockup = document.querySelector('.phone-mockup');
    
    if (!heroSection || !phoneMockup) return;
    
    window.addEventListener('scroll', () => {
        const scrolled = window.pageYOffset;
        const rate = scrolled * -0.5;
        
        if (scrolled < heroSection.offsetHeight) {
            phoneMockup.style.transform = `translateY(${rate}px) rotate(${scrolled * 0.05}deg)`;
        }
    });
}

// ===== ANIMACIONES DE CONTADOR =====
function initCounterAnimations() {
    const counters = document.querySelectorAll('[data-count]');
    
    const animateCounter = (counter) => {
        const target = parseInt(counter.getAttribute('data-count'));
        const duration = 2000;
        const increment = target / (duration / 16);
        let current = 0;
        
        const updateCounter = () => {
            current += increment;
            if (current < target) {
                counter.textContent = Math.floor(current).toLocaleString();
                requestAnimationFrame(updateCounter);
            } else {
                counter.textContent = target.toLocaleString();
            }
        };
        
        updateCounter();
    };
    
    // Observer para activar contadores cuando son visibles
    const counterObserver = new IntersectionObserver((entries) => {
        entries.forEach(entry => {
            if (entry.isIntersecting) {
                animateCounter(entry.target);
                counterObserver.unobserve(entry.target);
            }
        });
    });
    
    counters.forEach(counter => {
        counterObserver.observe(counter);
    });
}

// ===== EFECTO DE ESCRITURA =====
function initTypingEffect() {
    const typingElements = document.querySelectorAll('[data-typing]');
    
    typingElements.forEach(element => {
        const text = element.getAttribute('data-typing');
        const speed = parseInt(element.getAttribute('data-speed')) || 100;
        
        element.textContent = '';
        let i = 0;
        
        const typeWriter = () => {
            if (i < text.length) {
                element.textContent += text.charAt(i);
                i++;
                setTimeout(typeWriter, speed);
            } else {
                // Efecto de cursor parpadeante
                element.classList.add('typing-complete');
            }
        };
        
        // Iniciar cuando el elemento es visible
        const observer = new IntersectionObserver((entries) => {
            entries.forEach(entry => {
                if (entry.isIntersecting) {
                    setTimeout(typeWriter, 500);
                    observer.unobserve(entry.target);
                }
            });
        });
        
        observer.observe(element);
    });
}

// ===== EFECTOS DE PARTÍCULAS =====
function initParticleEffects() {
    const heroSection = document.querySelector('.hero');
    if (!heroSection) return;
    
    // Crear partículas flotantes
    for (let i = 0; i < 20; i++) {
        createParticle(heroSection);
    }
}

function createParticle(container) {
    const particle = document.createElement('div');
    particle.className = 'floating-particle';
    particle.style.cssText = `
        position: absolute;
        width: 4px;
        height: 4px;
        background: rgba(0, 159, 227, 0.3);
        border-radius: 50%;
        pointer-events: none;
        animation: float-particle ${5 + Math.random() * 10}s infinite linear;
        left: ${Math.random() * 100}%;
        top: ${Math.random() * 100}%;
        animation-delay: ${Math.random() * 5}s;
    `;
    
    container.appendChild(particle);
    
    // Remover partícula después de la animación
    setTimeout(() => {
        if (particle.parentNode) {
            particle.parentNode.removeChild(particle);
        }
    }, 15000);
}

// ===== INTERACTIVIDAD DE MOCKUPS =====
function initMockupInteractions() {
    const mockups = document.querySelectorAll('.phone-mockup, .screenshot-mockup');
    
    mockups.forEach(mockup => {
        mockup.addEventListener('mouseenter', () => {
            mockup.style.transform = 'scale(1.05) rotateY(5deg)';
            mockup.style.transition = 'all 0.3s ease';
        });
        
        mockup.addEventListener('mouseleave', () => {
            mockup.style.transform = 'scale(1) rotateY(0deg)';
        });
        
        // Efecto de tilt en mousemove
        mockup.addEventListener('mousemove', (e) => {
            const rect = mockup.getBoundingClientRect();
            const x = e.clientX - rect.left;
            const y = e.clientY - rect.top;
            
            const centerX = rect.width / 2;
            const centerY = rect.height / 2;
            
            const rotateX = (y - centerY) / 10;
            const rotateY = (centerX - x) / 10;
            
            mockup.style.transform = `perspective(1000px) rotateX(${rotateX}deg) rotateY(${rotateY}deg)`;
        });
    });
}

// ===== EFECTOS DE HOVER AVANZADOS =====
function initAdvancedHoverEffects() {
    // Efecto de ondas en botones
    const buttons = document.querySelectorAll('.btn');
    
    buttons.forEach(button => {
        button.addEventListener('click', function(e) {
            const ripple = document.createElement('span');
            const rect = this.getBoundingClientRect();
            const size = Math.max(rect.width, rect.height);
            const x = e.clientX - rect.left - size / 2;
            const y = e.clientY - rect.top - size / 2;
            
            ripple.style.cssText = `
                position: absolute;
                width: ${size}px;
                height: ${size}px;
                left: ${x}px;
                top: ${y}px;
                background: rgba(255, 255, 255, 0.3);
                border-radius: 50%;
                transform: scale(0);
                animation: ripple 0.6s linear;
                pointer-events: none;
            `;
            
            this.style.position = 'relative';
            this.style.overflow = 'hidden';
            this.appendChild(ripple);
            
            setTimeout(() => {
                ripple.remove();
            }, 600);
        });
    });
    
    // Efecto de magnetismo en cards
    const cards = document.querySelectorAll('.feature-card, .screenshot-card');
    
    cards.forEach(card => {
        card.addEventListener('mousemove', (e) => {
            const rect = card.getBoundingClientRect();
            const x = e.clientX - rect.left - rect.width / 2;
            const y = e.clientY - rect.top - rect.height / 2;
            
            card.style.transform = `translate(${x * 0.1}px, ${y * 0.1}px)`;
        });
        
        card.addEventListener('mouseleave', () => {
            card.style.transform = 'translate(0, 0)';
        });
    });
}

// ===== LAZY LOADING DE IMÁGENES =====
function initLazyLoading() {
    const images = document.querySelectorAll('img[data-src]');
    
    const imageObserver = new IntersectionObserver((entries) => {
        entries.forEach(entry => {
            if (entry.isIntersecting) {
                const img = entry.target;
                img.src = img.getAttribute('data-src');
                img.classList.remove('lazy');
                imageObserver.unobserve(img);
            }
        });
    });
    
    images.forEach(img => {
        imageObserver.observe(img);
    });
}

// ===== EFECTOS DE SONIDO (OPCIONAL) =====
function initSoundEffects() {
    // Solo si el usuario ha interactuado con la página
    let userInteracted = false;
    
    document.addEventListener('click', () => {
        userInteracted = true;
    });
    
    const buttons = document.querySelectorAll('.btn, .nav-link');
    
    buttons.forEach(button => {
        button.addEventListener('click', () => {
            if (userInteracted) {
                // Crear sonido de click (opcional)
                playClickSound();
            }
        });
    });
}

function playClickSound() {
    // Crear un sonido sintético simple
    const audioContext = new (window.AudioContext || window.webkitAudioContext)();
    const oscillator = audioContext.createOscillator();
    const gainNode = audioContext.createGain();
    
    oscillator.connect(gainNode);
    gainNode.connect(audioContext.destination);
    
    oscillator.frequency.setValueAtTime(800, audioContext.currentTime);
    oscillator.frequency.exponentialRampToValueAtTime(400, audioContext.currentTime + 0.1);
    
    gainNode.gain.setValueAtTime(0.1, audioContext.currentTime);
    gainNode.gain.exponentialRampToValueAtTime(0.01, audioContext.currentTime + 0.1);
    
    oscillator.start(audioContext.currentTime);
    oscillator.stop(audioContext.currentTime + 0.1);
}

// ===== PERFORMANCE MONITORING =====
function initPerformanceMonitoring() {
    // Monitorear FPS
    let lastTime = performance.now();
    let frameCount = 0;
    
    function measureFPS() {
        frameCount++;
        const currentTime = performance.now();
        
        if (currentTime - lastTime >= 1000) {
            const fps = Math.round((frameCount * 1000) / (currentTime - lastTime));
            
            if (fps < 30) {
                console.warn(`⚠️ FPS bajo detectado: ${fps}`);
                // Reducir efectos si es necesario
                reduceEffects();
            }
            
            frameCount = 0;
            lastTime = currentTime;
        }
        
        requestAnimationFrame(measureFPS);
    }
    
    measureFPS();
}

function reduceEffects() {
    // Desactivar efectos pesados si el rendimiento es bajo
    document.body.classList.add('reduced-effects');
}

// ===== UTILIDADES =====
function debounce(func, wait) {
    let timeout;
    return function executedFunction(...args) {
        const later = () => {
            clearTimeout(timeout);
            func(...args);
        };
        clearTimeout(timeout);
        timeout = setTimeout(later, wait);
    };
}

function throttle(func, limit) {
    let inThrottle;
    return function() {
        const args = arguments;
        const context = this;
        if (!inThrottle) {
            func.apply(context, args);
            inThrottle = true;
            setTimeout(() => inThrottle = false, limit);
        }
    };
}

// ===== INICIALIZACIÓN ADICIONAL =====
window.addEventListener('load', () => {
    // Inicializar efectos adicionales después de que todo esté cargado
    initMockupInteractions();
    initAdvancedHoverEffects();
    initLazyLoading();
    initSoundEffects();
    initPerformanceMonitoring();
    
    // Agregar clases CSS adicionales
    document.body.classList.add('loaded');
    
    console.log('✨ Todos los efectos cargados correctamente');
});

// ===== MANEJO DE ERRORES =====
window.addEventListener('error', (e) => {
    console.error('❌ Error en la página:', e.error);
    // No romper la experiencia del usuario por errores menores
});

// ===== CSS ADICIONAL DINÁMICO =====
const additionalCSS = `
    @keyframes ripple {
        to {
            transform: scale(4);
            opacity: 0;
        }
    }
    
    @keyframes float-particle {
        0% {
            transform: translateY(100vh) translateX(0);
            opacity: 0;
        }
        10% {
            opacity: 1;
        }
        90% {
            opacity: 1;
        }
        100% {
            transform: translateY(-100px) translateX(100px);
            opacity: 0;
        }
    }
    
    @keyframes pulse {
        0% { transform: scale(1); }
        50% { transform: scale(1.05); }
        100% { transform: scale(1); }
    }
    
    .typing-complete::after {
        content: '|';
        animation: blink 1s infinite;
    }
    
    @keyframes blink {
        0%, 50% { opacity: 1; }
        51%, 100% { opacity: 0; }
    }
    
    .reduced-effects * {
        animation-duration: 0.01ms !important;
        animation-iteration-count: 1 !important;
        transition-duration: 0.01ms !important;
    }
    
    .loaded {
        opacity: 1;
        transition: opacity 0.3s ease;
    }
    
    .lazy {
        opacity: 0;
        transition: opacity 0.3s;
    }
`;

// Inyectar CSS adicional
const style = document.createElement('style');
style.textContent = additionalCSS;
document.head.appendChild(style);
