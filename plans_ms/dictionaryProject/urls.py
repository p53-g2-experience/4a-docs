"""dictionaryProject URL Configuration

The `urlpatterns` list routes URLs to views. For more information please see:
    https://docs.djangoproject.com/en/3.2/topics/http/urls/
Examples:
Function views
    1. Add an import:  from my_app import views
    2. Add a URL to urlpatterns:  path('', views.home, name='home')
Class-based views
    1. Add an import:  from other_app.views import Home
    2. Add a URL to urlpatterns:  path('', Home.as_view(), name='home')
Including another URLconf
    1. Import the include() function: from django.urls import include, path
    2. Add a URL to urlpatterns:  path('blog/', include('blog.urls'))
"""
from django.contrib import admin
from django.urls import path, include
from rest_framework_simplejwt.serializers import TokenRefreshSerializer
from rest_framework_simplejwt.views import (TokenObtainPairView, TokenRefreshView)
from dictionaryApp import views
from rest_framework.urlpatterns import format_suffix_patterns

urlpatterns = [
    path('login/',TokenObtainPairView.as_view()),
    path('refresh/', TokenRefreshView.as_view()),
    path('verifyToken/', views.VerifyTokenView.as_view()),
    path('admin/', admin.site.urls),
    path('word/', include('dictionaryApp.views.word.wordUrls')),
    path('word/', views.WordCreateView.as_view()),
    path('word/<int:pk>/', views.WordDetailsView.as_view()),
]

admin.site.site_header = "Diccionario Indígena"
urlpatterns = format_suffix_patterns(urlpatterns)