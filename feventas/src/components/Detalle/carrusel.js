import React, { useState } from 'react';
import ArrowBackIosRoundedIcon from '@material-ui/icons/ArrowBackIosRounded';
import ArrowForwardIosIcon from '@material-ui/icons/ArrowForwardIos';
import Card from '@material-ui/core/Card';


export const SliderData = [
    {
      id:1,
      imagen:
      "https://t-mobile.scene7.com/is/image/Tmusprod/fg-iphone-13-pink_750x750_nologo-2?wid=750&hei=750&fmt=png-alpha"
    },
    {
      imagen:
      "https://www.eluniverso.com/resizer/hMv5jI4dIDDDEDyrVxfOLQnWPSk=/1004x670/smart/filters:quality(70)/cloudfront-us-east-1.images.arcpublishing.com/eluniverso/5ZMYXYI2ORDLLLNE3RORUY33SQ.jpg"
    },
    {
      imagen:
      'https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/telefonos-plegables-portada-1634393440.jpg?crop=0.564xw:1.00xh;0.171xw,0&resize=640:*'
    }
  ];



const ImgCarousel = ({ slides }) => {
  const [actual, setActual] = useState(0);
  const length = slides.length;

  const nextSlide = () => {
    setActual(actual === length - 1 ? 0 : actual + 1);
  };

  const prevSlide = () => {
    setActual(actual === 0 ? length - 1 : actual - 1);
  };

  if (!Array.isArray(slides) || slides.length <= 0) {
    return null;
  }

  return (
    <Card className='slider' >
      <ArrowBackIosRoundedIcon className='left-arrow' onClick={prevSlide} />
      <ArrowForwardIosIcon className='right-arrow' onClick={nextSlide} />
      {SliderData.map((slide, index) => {
        return (
          <div className={index === actual ? 'slide-active' : 'slide'} key={index}>
            {index === actual && (<img src={slide.imagen} className='carousel-image' />) 
           }
          </div>
        );
      })}
    </Card>
  );
};

export default ImgCarousel;